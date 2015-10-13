/**パッケージ宣言*/
var minokuba = minokuba || {};
minokuba.twitterclient = minokuba.twitterclient || {};
minokuba.twitterclient.model = minokuba.twitterclient.model || {};

minokuba.twitterclient.model.Tweet = Backbone.Model.extend({

    //modelの独自編集を行う。Backbone.Modelのメソッドをオーバーライド
    parse: function (model) {
        var relativeTime = moment(model.createdAt).fromNow();
        model.relativeTime = relativeTime;
        return model;
    }

});