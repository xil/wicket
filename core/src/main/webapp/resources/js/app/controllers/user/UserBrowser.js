/**
 * User: Alexey Nevinsky
 * Date: 06.07.13 21:06
 */
define([
    "dojo/_base/declare", "dojo/_base/lang",

    "controllers/common/AbstractController",

    "views/user/UserBrowserView", "dojo/store/JsonRest", "dojo/data/ItemFileReadStore"    ,
    "controllers/user/edit/UserEditor"
], function (declare, lang, AbstractController, UserBrowserView, JsonRest, ItemFileReadStore, UserEditor) {
    return declare("controllers.user.UserBrowser", [AbstractController], {

        _viewTemplateString: "ws/rest/user/template",
        currentTab: null,
        userStore: null,
        view: null,

        init: function () {
            this._initUserStore();

//            TODO rework it!
            this.view = new UserBrowserView(this._getViewParams());
//            this.currentTab.addChild(this.view);
            this.view.placeAt(this.currentTab);
            this.view.startup();
            this._addListeners();
        },
        _addListeners: function () {
            this.view.on("create", lang.hitch(this, function (params) {
                this._openEditor(null);
            }));
            this.view.on("edit", lang.hitch(this, function (params) {
                var selectedId = this.view.selectedRowId;
                this._openEditor(this.view.getSelectedId(selectedId));
            }));
            this.view.on("refresh", lang.hitch(this, function (params) {
                this.view.refresh();
            }));
        },
        _openEditor: function (itemId) {
            var editor = new UserEditor({itemId: itemId});
            editor.init();
        },
        _getViewParams: function () {
            var self = this;

            var storeParams = {
                url: "ws/rest/user/list"
            };
            var viewStore = this.userStore = new ItemFileReadStore(storeParams);
            var params = {
                currentTab: self.currentTab,
                app: this.app,
                templateString: self._getTemplateString(),
                viewStore: viewStore
            };
            return params;
        },
        _initUserStore: function () {

        }

    });
})
;