class Solution {
    class WebPage {
        int index;
        int matchScore;
        String url;
        String[] links;
        double linkScore;

        WebPage(int index) {
            this.index = index;
        }
    }

    public int solution(String word, String[] pages) {
        int length = pages.length;
        int answer = 0;
        double max = 0;
        double linkScore;
        double[] score = new double[length];
        String[] uris = new String[150];
        WebPage page;
        java.util.Map<String, WebPage> webPages = new java.util.HashMap<>();
        java.util.regex.Pattern searchPattern = java.util.regex.Pattern.compile(
                "(?<=\\b|[^A-Za-z])(?i)" + word + "(?=\\b|[^A-Za-z])");
        java.util.regex.Pattern urlPattern = java.util.regex.Pattern.compile(
                "(?<=<meta property=\"og:url\" content=\"https://)\\S+?(?=\"/>)");
        java.util.regex.Pattern linkPattern = java.util.regex.Pattern.compile(
                "(?<=<a href=\"https://)\\S+?(?=\">)");
        java.util.regex.Matcher match;

        for (int i = 0; i < length; i++) {
            page = new WebPage(i);
            match = searchPattern.matcher(pages[i]);
            page.matchScore = getMatchCount(match);
            match = urlPattern.matcher(pages[i]);
            page.url = getUrl(pages[i], match);
            match = linkPattern.matcher(pages[i]);
            page.links = getLinks(pages[i], match, uris);
            webPages.put(page.url, page);
        }
        for (WebPage wp : webPages.values()) {
            uris = wp.links;
            linkScore = wp.matchScore / (double) uris.length;
            for (String s : uris) {
                page = webPages.get(s);
                if (page != null) {
                    page.linkScore += linkScore;
                }
            }
        }
        for (WebPage wp : webPages.values()) {
            score[wp.index] = wp.matchScore + wp.linkScore;
        }
        for (int i = 0; i < length; i++) {
            if (score[i] > max) {
                answer = i;
                max = score[i];
            }
        }
        return answer;
    }

    int getMatchCount(java.util.regex.Matcher match) {
        int count = 0;
        int end;
        boolean isFind = match.find();

        while (isFind) {
            count++;
            end = match.end();
            isFind = match.find(end);
        }
        return count;
    }

    String getUrl(String page, java.util.regex.Matcher match) {
        match.find();
        return page.substring(match.start(), match.end());
    }

    String[] getLinks(String page, java.util.regex.Matcher match, String[] uris) {
        int count = 0;
        int end;
        boolean isFind = match.find();

        while (isFind) {
            end = match.end();
            uris[count++] = page.substring(match.start(), end);
            isFind = match.find(end);
        }
        return java.util.Arrays.copyOf(uris, count);
    }
}