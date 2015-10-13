/**パッケージ宣言*/
var minokuba = minokuba || {};
minokuba.twitterclient = minokuba.twitterclient || {};
minokuba.twitterclient.collection = minokuba.twitterclient.collection || {};

minokuba.twitterclient.collection.Timeline = Backbone.Collection.extend({
    model: minokuba.twitterclient.model.Tweet,
    url: "/api/twitter/userTimeline",
    initialize: function () {
        //初期化処理
    }
});