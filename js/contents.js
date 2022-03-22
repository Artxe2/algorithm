const URL_PATH = "/algorithm/";
const today = new Date()
const _root = document.querySelector("#root")
const _logo = document.querySelector("#logo")
const _contents = document.querySelector("#contents")
const _list = document.querySelector("#list")

document.addEventListener('DOMContentLoaded', (e) => {
    _logo.setAttribute("href", URL_PATH)
    readUrl()
})

const fold = (e, el) => {
    e.stopPropagation()

    const lis = el.parentNode.querySelectorAll(':scope > ul > li')

    for (const li of lis) {

        if (li.className.indexOf("none") >= 0) {
            li.className = li.className.replace("none", "").trim()
        } else {
            li.className = (li.className + " none").trim()
        }
    }
}

const getCount = obj => {
    if (obj instanceof Array) {
        return obj.length;
    }
    var result = 0;

    for (const key of Object.keys(obj)) {
        result += getCount(obj[key])
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
    const hljs = document.querySelectorAll('.language-java.hljs')

    for (const hl of hljs) {
        const keywords = hl.querySelectorAll('.hljs-keyword')

        for (const el of keywords) {
            switch (el.innerHTML) {
                case "class":
                case "public":
                case "private":
                case "static":
                case "final":
                    el.classList = [ "hljs-modifier" ];
                    break;
                case "void":
                    el.classList = [ "hljs-type" ];
            }
        }
        hl.innerHTML = hl.innerHTML
                .replace(/\?/gi, `<span class="hljs-keyword">?</span>`)
                .replace(/\:/gi, `<span class="hljs-keyword">:</span>`)
                .replace(/<span class="hljs-meta">@Override<\/span>/gi,
                        `@<span class="hljs-meta">Override</span>`)

        const strings = hl.querySelectorAll('.hljs-string')

        for (const el of strings) {
            el.innerHTML = el.innerText;
        }

        const classes = hl.querySelectorAll('.hljs-title.class_')
        const set = new Set()

        for (const el of classes) {
            set.add(el.innerText)
        }
        for (const s of set) {
            hl.innerHTML = hl.innerHTML
                .replace(
                    new RegExp(`(?<=\\s)${s}(?=\\s|\\[)`, "gi")
                    , `<span class="hljs-type">${s}</span>`
                )
        }
        hl.innerHTML = hl.innerHTML
            .replace(
                /(?<= |\()System|Math(?=\.)/gi
                , s => `<span class="hljs-title class_">${s}</span>`
            )
            .replace(
                /java.util.<span class="hljs-type">Random<\/span>|<span class="hljs-title class_">java<\/span>.util.Random/gi
                , `<span class="hljs-package">java.util.Random</span>`
            )
            .replace(
                /java.util.[A-Za-z]+(?= |&lt;|\.)/gi
                , s => `<span class="hljs-package">${s}</span>`
            )
            .replace(
                /<span class="hljs-title class_">java<\/span>.util.[A-Za-z]+(?=&lt;)/gi
                , s => `${s.replace("hljs-title class_", "hljs-package").replace("</span>", "")}</span>`
            )
            .replace(
                /(?<= |\.|\(|\[|--|\+\+)[A-Za-z0-9\_]+(?= |;|\.|\[|\]|,|\)|--|\+\+)/gi
                , s => `<span class="hljs-variable">${s}</span>`
            )
            .replace(
                /(?<= |\.)[A-Za-z0-9\_]+(?=\()/gi
                , s => `<span class="hljs-title function_">${s}</span>`
            )
            .replace(
                /\([A-Za-z0-9\_]+(?=\()/gi
                , s => `(<span class="hljs-title function_">${s.substring(1)}</span>`
            )
            .replace(
                /(?<=&lt;|, )[A-Za-z0-9\_]+(?=&gt;|, )/gi
                , s => `<span class="hljs-type">${s}</span>`
            )

        const coments = hl.querySelectorAll('.hljs-comment')

        for (const el of coments) {
            el.innerHTML = el.innerText;
        }

        const packages = hl.querySelectorAll('.hljs-package')
        
        for (const el of packages) {
            el.innerHTML = el.innerText;
        }
    }
}

const parseUrlSafe = url => url.replace(/ /gi, "-")
        .replace(/[\[\]\?]/gi, '')

const readUrl = () => {
    const url = new URLSearchParams(document.location.search)

    showList()
    showContent(url.get("link"), url.get("algo"))
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

                _contents.innerHTML = "<h3>" + link.replace(/\//gi, " > ")
                        .replace(/_/gi, " ") + "</h3>"
                        + "<h1>" + getTitle(unfoldList(link), algo) + "</h1>"
                        + hash + md;
                hljs.initHighlighting.called = false;
                hljs.highlightAll()
                highlightCustom()
                window.scrollTo(0, 0)
            }
        })
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
    const path = link.split("/")
    let obj = list;

    for (const p of path) {
        const lis = document.querySelector("." + p)
                .parentNode.querySelectorAll(":scope > ul > li")

        for (const li of lis) {
            li.className = li.className.replace("none", "").trim()
        }
        obj = obj[p];
    }
    return obj;
}