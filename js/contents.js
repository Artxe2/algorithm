// const URL_PATH = "/";
const URL_PATH = "/algorithm/";
const today = new Date();
const _root = document.querySelector("#root");
const _contents = document.querySelector("#contents");
const _list = document.querySelector("#list");

window.onpopstate = () => {
    getUrl();
}
document.addEventListener('DOMContentLoaded', (e) => {
    getUrl();

    var html = "<ul>"

    for (const lang of Object.keys(list)) {
        html += "<li><span class='lang'>" + lang + ": <b>" + getCount(list[lang]) + "</b></span><ul>"
        for (const site of Object.keys(list[lang])) {
            html += "<li><span class='site'>" + site + ": <b>" + getCount(list[lang][site]) + "</b></span><ul>"
            if (site == "algorithm") {
                for (const al of list[lang][site]) {
                    html += `<li><a class="algo" onclick="pushState('`
                            + lang + `/` + site + `','` + al
                            + `')">` + al.replaceAll('-', ' ') + `</a></li>`;
                }
            } else {
                for (const diff of Object.keys(list[lang][site])) {
                    html += "<li><span class='diff'>" + diff + ": <b>" + getCount(list[lang][site][diff]) + "</b></span><ul>"
                    for (const algo of list[lang][site][diff]) {
                        html += `<li><a class="algo" onclick="pushState('`
                                + lang + `/` + site + `/` + diff + `','` + algo[0]
                                + `')">` + algo[0].replaceAll('-', ' ') + (algo[1] ? ` # ` + algo[1] : ``) + `</a></li>`;
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
});

getCount = obj => {
    if (obj instanceof Array) {
        return obj.length;
    }
    var result = 0;

    for (const key of Object.keys(obj)) {
        console.log(obj[key] instanceof Object)
        result += getCount(obj[key]);
    }
    return result;
}

getUrl = () => {
    const url = new URLSearchParams(document.location.search);

    showContent(url.get("link"), url.get("algo"));
}

pushState = (link, algo) => {
    const url = new URLSearchParams(document.location.search);

    if (link != url.get("link") || algo != url.get("algo")) {
        history.pushState(null, null, link && algo ? URL_PATH + "?link=" + link + "&algo=" + algo : URL_PATH);
        showContent(link, algo);
    }
}

showContent = (link, algo) => {
    if (link && algo) {
        _root.classList = [ ];
        ajax({
            url: URL_PATH + link + "/" + algo.replaceAll('[', '').replaceAll(']', '') + ".md?" + today
            , success: res => {
                _contents.innerHTML = "<h3>" + link + "</h3>"
                        + "<h1>" + algo.replaceAll('-', ' ') + "</h1>" + marked.parse(res);
                hljs.initHighlighting.called = false;
                hljs.initHighlighting();

                for (const codeHl of document.querySelectorAll(".hljs")) {
                    for (const hlParam of codeHl.querySelectorAll(".hljs-params")) {
                        var t = hlParam.innerHTML;
                        const a = t.substr(1, t.length - 2).split(",");
                        for (var i in a) {
                            if (a[i].charAt(0) != '<' && a[i].charAt(1) != '<') {
                                var x = a[i].indexOf(" ", 1);

                                a[i] = `<span class="hljs-type">` + a[i].substring(0, x)
                                        + `</span>` + a[i].substring(x);
                            }
                        }
                        hlParam.innerHTML = "(" + a.join() + ")";
                    }
                }
            }
        });
    } else {
        _contents.innerHTML = "";
        _root.classList = [ "reverse" ];
    }
}