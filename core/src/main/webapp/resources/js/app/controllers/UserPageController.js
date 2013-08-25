/**
 * Created with IntelliJ IDEA.
 * User: inver
 * Date: 16.10.12
 * Time: 13:35
 * To change this template use File | Settings | File Templates.
 */

define([
    "dojo/_base/declare", "dojo/_base/lang",

    "models/RestModel",

//    "views/userPage/UserPage"
], function (declare, lang, RestModel) {
    return declare(null, {
        systemUser:"",

        constructor:function (options) {
            lang.mixin(this, options);
            this.model = new RestModel();


//            this.model = new SimpleCashModel({systemUser:this.systemUser});

//            window.onbeforeunload = lang.hitch(this, function () {
//                this.model.commit();
//            });
        },
        init:function () {
//            this.view = new UserPage({model:this.model}, "container");
//
//            this.view.startup();



//            this.view.on("addCash", lang.hitch(this, function (cashValue) {
//                this.addCash(cashValue);
//            }));
//            this.view.on("withdrawCash", lang.hitch(this, function (cashValue) {
//                this.addCash("-" + cashValue);
//            }));
        }
//        addCash:function (cashValue) {
//            var cash = parseFloat(cashValue);
//            this.model.addCash(cash);
//        },
//        _refreshModels:function () {
//            this.model.get().then(function (item) {
//
//            });
//        }
    });
});
