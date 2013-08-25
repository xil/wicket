/**
 * Created with IntelliJ IDEA.
 * User: inver
 * Date: 19.10.12
 * Time: 18:18
 * To change this template use File | Settings | File Templates.
 */

define([
    "dojo/_base/declare", "dojo/Stateful", "dojox/mvc/getStateful", "dojo/store/JsonRest", "dojox/mvc",
    "dojo/_base/lang"],
    function (declare, Stateful, getStateful, JsonRest, mvc, lang) {
        return declare([Stateful], {
            counts:new Stateful(),

            pathIds:{
                countId:"counts"
            },

            store:new JsonRest({
                target:"ws/rest/"
            }),
            constructor:function () {
                this.__initModel();
                this.store.get(this.pathIds.countId).then(lang.hitch(this, function (item) {
                    this.counts.set("currentCount", getStateful(item.currentCount));
                    this.counts.set("maxCount", getStateful(item.maxCount));
                }));
            },

            __initModel:function () {
            }
        });
    }
);
