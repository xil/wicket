/**
 * User: Alexey Nevinsky
 * Date: 06.07.13 21:06
 */
define([
    "./UserEditorView",
    "controllers/common/AbstractController",

    "dojo/_base/declare",
    "dojo/_base/lang",
    "dojo/data/ItemFileReadStore",
    "dojo/store/JsonRest",
    "dojo/when",

    "dojox/mvc/EditStoreRefController",
    "dojox/mvc/getPlainValue",
    "dojox/mvc/getStateful"
], function (UserEditorView, AbstractController, declare, lang, ItemFileReadStore, JsonRest, when, EditStoreRefController, getPlainValue, getStateful) {
    return declare("controllers.user.UserBrowser", [AbstractController, EditStoreRefController], {

        _viewTemplateString: "ws/rest/user/editTemplate",
        currentTab: null,
        view: null,
        itemId: null,

        init: function () {
            this.holdModelUntilCommit = true;
            this.store = new JsonRest({target: "ws/rest/user/"});

            if (!this.itemId) {
                var item = getStateful({firstname: "", middlename: "", lastname: ""});
                this.set(this._refSourceModelProp, item);
                this._openView();
            } else {
                when(this.getStore(this.itemId), lang.hitch(this, function () {
                    this._openView();
                }));
            }
            this._addListeners();
        },
        _openView: function () {
            this.view = new UserEditorView(this._getViewParams());
            var view = this.view;
            view.startup();
            view.show();

            var self = this;
            view.on("commitAction", function (params) {
                self.commit(function () {
                    self.view.hide();
                    self.emit("commitAction", {});
                }, function () {
//                    show err dialog or others
                });
            });
            view.on("closeAction", function (params) {
                self.view.hide();
                self.emit("closeAction", {});
            });
            view.on("applyAction", function (params) {
                self.commit(function (params) {
                    self.itemId = params.id;
                    self.getStore(self.itemId)
                    self.view.enableScanning();
                }, function () {
                //show err dialog or others
                });
            });
            view.on("scanningAction", function (params) {
                var xhrArgs = {
                      url: "ws/rest/user/scanning/" + self.itemId,
                      postData: "SCANNING!!!",
                      handleAs: "text",
                      load: function(data){
                      },
                      error: function(error){
                      }
                }
                var deferred = dojo.xhrPost(xhrArgs);
            });
        },
        commit: function (callback, errback) {
//            bcz data is plain -> remove actions with arrays. Data can only saved -> remove deleting actions
            var data = getPlainValue(this.get(this._refEditModelProp), this.getPlainValueOptions);
            var resultDeferred = this.store.put(data);
            resultDeferred.addCallback(callback);
            resultDeferred.addErrback(errback);
        },
        _addListeners: function () {
//            this.mainPane.on("clickMenuBarItem_logout", function () {
//                window.location.href = "/logout";
//            });
        },
        _getViewParams: function () {
            var self = this;

            var storeParams = {
                url: "ws/rest/user/list"
            };
            var viewStore = new ItemFileReadStore(storeParams);
            var params = {
                contentParams: {
                    currentTab: self.currentTab,
                    app: this.app,
                    templateString: self._getTemplateString(),
                    viewStore: viewStore,
                    ctrl: self,
                    style: {},
                    scanningEnabled: !!this.itemId
                }
            };
            return params;
        }

    });
})
;