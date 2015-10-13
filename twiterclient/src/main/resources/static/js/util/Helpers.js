$(function () {
    //Handlebarsのカスタムヘルパーを登録。テンプレートから「formatTweets」で呼び出せる。
    //リンクと@xx のリンク化を行っている。
    Handlebars.registerHelper("formatTweeet", function (str) {
        var link, url, username;
        if (str) {
            str = str.replace(/https?:\/\/[\w/:%#\$&\?\(\)~\.=\+\-]+/g, function (l) {
                link = '<a href="' + l + '" target="#">' + l + '</a>';
                return link;
            });

            str = str.replace(/[@]+[A-Za-z0-9-_]+/g, function (m) {
                username = m.replace("@", "");
                url = "http://twitter.com/" + username;
                link = '<a href="' + url + '" target="#">@' + username + '</a>';
                return link;
            });
            return new Handlebars.SafeString(str);
        } else {
            return str;
        }
    });
});