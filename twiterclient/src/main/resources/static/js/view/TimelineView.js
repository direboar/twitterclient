/**パッケージ宣言*/
var minokuba = minokuba || {};
minokuba.twitterclient = minokuba.twitterclient || {};
minokuba.twitterclient.view = minokuba.twitterclient.view || {};

minokuba.twitterclient.view.TimelineView = Backbone.View.extend({

    el: "#timeline",　//置き換え先のDIVタグのID
    template: Handlebars.compile($("#timeline-template").html()),　//テンプレートをコンパイル。
    timeline: null,
    
    //初期化処理
    initialize: function () {
        //thisの束縛。underscore.jsの仕様変更のため、束縛するメソッド名を全て指定しないといけなくなった…。
        _.bindAll(this, "initialize", "render");

        //timelineを生成
        this.timeline = new minokuba.twitterclient.collection.Timeline();
        //リセットイベントをトリガーに、renderを呼び出すようにイベントハンドラを設定。
        this.listenTo(this.timeline, 'reset', this.render);

        //とりあえず初期表示
        this.render();
        //fetch。その際、リセットイベントを発行(fetchしたtweetを、元々持っていたコレクションと差し替える。)
        this.timeline.fetch({
            reset: true
        });
    },
    
    //描画処理
    render: function () {
        if (this.timeline.size() > 0) {
        	//timelineオブジェクトのJSONオブジェクト配列を元にテンプレート評価し、戻り値を<div>タグにアペンド。
            var tweets = this.timeline.toJSON();
            var output = this.template({
                tweets: tweets
            });
            this.$el.append(output);
        }
        return this;
    }

});