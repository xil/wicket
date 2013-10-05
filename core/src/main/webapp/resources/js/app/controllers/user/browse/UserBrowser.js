/**
 * User: Alexey Nevinsky
 * Date: 06.07.13 21:06
 */
define([
    "controllers/common/AbstractController",
    "controllers/LoginController",
    "controllers/user/edit/UserEditor",

    "dojo/_base/declare",
    "dojo/_base/lang",
    "dojo/data/ObjectStore",
    "dojo/store/JsonRest",

    "controllers/user/browse/UserBrowserView"

], function (AbstractController, LoginController, UserEditor, declare, lang, ObjectStore, JsonRest, UserBrowserView) {
    return declare("controllers.user.UserBrowser", [AbstractController], {

        _viewTemplateString: "ws/rest/user/template",
        currentTab: null,
        userStore: null,
        view: null,
        dsContext: null,

        init: function () {
//            TODO rework it!
            this.view = new UserBrowserView(this._getViewParams());
            this.view.placeAt(this.currentTab);
            this.view.startup();
            this._addListeners();
        },
        _initDsContext: function () {
            this.dsContext = {

            }
        },
        _addListeners: function () {
            var self = this;
            this.view.on("create", lang.hitch(this, function (params) {
                this._openEditor(null);
            }));
            this.view.on("edit", lang.hitch(this, function (params) {
                var selectedId = this.view.selectedRowId;
                if (undefined != selectedId) {
                    this._openEditor(this.view.getSelectedId(selectedId));
                }
            }));
            this.view.on("remove", lang.hitch(this, function (params) {
                var selectedId = this.view.selectedRowId;
                if (undefined != selectedId) {
//                    TODO
                    self.userStore.deleteItem(this.view.getSelectedItem());
                    self.userStore.save();
                }
            }));
            this.view.on("refresh", lang.hitch(this, function (params) {
                this._refreshStore();
//                self.userStore.fetch();
            }));
        },
        _openEditor: function (itemId) {
            var editor = new UserEditor({itemId: itemId});
            editor.init();
            var self = this;
            editor.on("commitAction", function (params) {
                self._refreshStore();
                self._refreshStore();//dirty hack for clean cache. TODO: rework it!

            });
        },
        _getViewParams: function () {
            var self = this;

            var storeParams = {
//                url: "ws/rest/user/list"
                target: "ws/rest/user/", idProperty: "id"
            };
//            TODO replace to JsonRestStore
            var restUserStore = this.restUserStore = new JsonRest(storeParams);
            var viewStore = this.userStore = new ObjectStore({objectStore: restUserStore});
            var params = {
                currentTab: self.currentTab,
                app: this.app,
                templateString: self._getTemplateString(),
                viewStore: viewStore
            };
            return params;
        },
//        TODO rework it
        _refreshStore: function () {
//            var storeParams = {
//            url: "ws/rest/user/list"
//                target: "ws/rest/user/list", idAttribute: "id"
//            };
//            var self = this;
//            var restUserStore = this.restUserStore;
            var viewStore = this.userStore;
//            = new ObjectStore({objectStore: restUserStore});
//            viewStore.onDelete = function () {
//                self._refreshStore();
//            }
            this.view.usersGrid.setStore(viewStore, "/list");
        }

    });
})
;