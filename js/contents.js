const URL_PATH = "/algorithm/";
const today = new Date();
const _root = document.querySelector("#root");
const _logo = document.querySelector("#logo");
const _contents = document.querySelector("#contents");
const _list = document.querySelector("#list");

document.addEventListener('DOMContentLoaded', (e) => {
    _logo.setAttribute("href", URL_PATH);
    readUrl();
});

const fold = (e, el) => {
    e.stopPropagation();

    const lis = el.parentNode.querySelectorAll(':scope > ul > li');

    for (const li of lis) {

        if (li.className.indexOf("none") >= 0) {
            li.className = li.className.replace("none", "").trim();
        } else {
            li.className = (li.className + " none").trim();
        }
    }
}

const getCount = obj => {
    if (obj instanceof Array) {
        return obj.length;
    }
    var result = 0;

    for (const key of Object.keys(obj)) {
        result += getCount(obj[key]);
    }
    return result;
}

const getTitle = (obj, algo) => {
    if (obj[0] instanceof Array) {
        for (const arr of obj) {
            if (parseUrlSafe(arr[0]) === algo) {
                return arr[0];
            }
        }
    } else {
        for (const tt of obj) {
            if (tt === algo) {
                return tt;
            }
        }
    }
}

const highlightCustom = () => {
    const hljs = document.querySelectorAll('.language-java.hljs');

    for (const hl of hljs) {
        const keywords = hl.querySelectorAll('.hljs-keyword');

        for (const el of keywords) {
            switch (el.innerHTML) {
                case "class": case"public":
                    el.classList.add("prefix");
                    break;
                case "static":
                    el.classList.add("prefix");
                    break;
                case "void":
                    el.classList.add("hljs-type");
            }
        }
        hl.innerHTML = hl.innerHTML
                .replaceAll("?", `<span class="hljs-keyword">?</span>`)
                .replaceAll(":", `<span class="hljs-keyword">:</span>`);
    }
}

const parseUrlSafe = url => url.replaceAll(" ", "-")
        .replaceAll('[', '').replaceAll(']', '').replaceAll('?', '');

const readUrl = () => {
    const url = new URLSearchParams(document.location.search);

    showList();
    showContent(url.get("link"), url.get("algo"));
}

const showContent = (link, algo) => {
    if (link && algo) {
        _root.classList = [ ];
        ajax({
            url: URL_PATH + "md/" + link + "/" + algo + ".md?" + today
            , success: res => {
                const md = window.markdownit().render(res)
                let path = list;
                let hash = "<div id='hash'>";

                for (const p of link.split("/")) {
                    path = path[p];
                }
                for (const a of path) {
                    if (parseUrlSafe(a[0]) === algo) {
                        for (let i = 1; i < a.length; i++) {
                            hash = hash + "<code class='hash'># " + a[i] + "</code>";
                        }
                        break;
                    }
                }
                hash = hash + "</div>";

                _contents.innerHTML = "<h3>" + link + "</h3>"
                        + "<h1>" + getTitle(unfoldList(link), algo) + "</h1>"
                        + hash + md;
                hljs.initHighlighting.called = false;
                hljs.highlightAll();
                highlightCustom();
                window.scrollTo(0, 0);
            }
        });
    } else {
        _contents.innerHTML = "";
        _root.classList = [ "reverse" ];
    }
}

const showList = () => {
    var html = "<ul>"

    for (const lang of Object.keys(list)) {
        html += "<li><span class='lang " + lang  + "' onclick='fold(event,this)'>"
                + lang + ": <b>" + getCount(list[lang]) + "</b></span><ul>"
        for (const site of Object.keys(list[lang])) {
            html += "<li><span class='site " + site  + "' onclick='fold(event,this)'>" 
                    + site + ": <b>" + getCount(list[lang][site]) + "</b></span><ul>"
            if (site === "algorithm") {
                for (const algo of list[lang][site]) {
                    html += `<li class='none'><a class="algo" href="` + URL_PATH
                            + `?link=` + lang + `/` + site + `&algo=` + algo
                            + `">` + algo + `</a></li>`;
                }
            } else {
                for (const diff of Object.keys(list[lang][site])) {
                    html += "<li class='none'><span class='diff " + diff
                            + "' onclick='fold(event,this)'>" + diff + ": <b>"
                            + getCount(list[lang][site][diff])
                            + "</b></span><ul>"
                    for (const algo of list[lang][site][diff]) {
                        html += `<li class='none'><a class="algo" href="` + URL_PATH
                                + `?link=` + lang + `/` + site + `/` + diff + `&algo=`
                                + parseUrlSafe(algo[0])
                                + `">` + algo[0] + (algo[1] ? ` # ` + algo[1] : ``)
                                + `</a></li>`;
                    }
                    html += "</ul></li>";
                }
            }
            html += "</ul></li>";
        }
        html += "</ul></li>";
    }
    html += "</ul>";
    _list.innerHTML = html;
}

const unfoldList = link => {
    const path = link.split("/");
    let obj = list;

    for (const p of path) {
        const lis = document.querySelector("." + p)
                .parentNode.querySelectorAll(":scope > ul > li");

        for (const li of lis) {
            li.className = li.className.replace("none", "").trim();
        }
        obj = obj[p];
    }
    return obj;
}