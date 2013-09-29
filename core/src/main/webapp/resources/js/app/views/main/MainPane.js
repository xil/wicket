/**
 * Created with IntelliJ IDEA.
 * User: inver
 * Date: 16.10.12
 * Time: 13:37
 * To change this template use File | Settings | File Templates.
 */

define([
    "dojo/_base/declare", "dojo/_base/lang", "dojo/Evented", "dojo/i18n!nls/messages",

    "dijit/_WidgetBase", "dijit/_TemplatedMixin", "dijit/_WidgetsInTemplateMixin",

    "dojox/mvc/at", "dijit/layout/TabContainer", "dijit/Menu", "dijit/MenuItem", "dijit/MenuBar", "dijit/MenuBarItem", "dijit/layout/ContentPane",

    "dijit/layout/BorderContainer", "views/common/AbstractView"
], function (declare, lang, Evented, messages, _WidgetBase, _TemplatedMixin, _WidgetsInTemplateMixin, at, TabContainer, Menu, MenuItem, MenuBar, MenuBarItem, ContentPane, BorderContainer, AbstractView) {
        return declare([AbstractView], {
//            templateString: template,

            layout: null,
            menuWidget: null,
            tabContainer: null,
            tabContainerInitialized: false,
            tabs: [],

            constructor: function (options) {
                lang.mixin(this, options);
            },
            init: function () {
                this.mainLayout.startup();
                this._initMenu();
                this._initMainArea();
            },
            _initMenu: function () {
                this.menuWidget = new MenuBar({});
                this.menuWidget.addChild(this._createMenubarButton('wicket'));
                this.menuWidget.addChild(this._createMenubarButton('users'));
                this.menuWidget.addChild(this._createMenubarButton('idents'));
                this.menuWidget.addChild(this._createMenubarButton("logout"));
                this.menu.addChild(this.menuWidget);
            },
            _initMainArea: function () {
                this.tabContainer = new TabContainer({});
                this.mainArea.addChild(this.tabContainer);
                this.mainLayout.layout();

            },
            addTab: function (caption, viewId) {
                var tabContent = false;
                var tabs = this.tabs;
                if (!tabs[viewId]) {
                    var self = this;
                    tabContent = new ContentPane({
                        title: caption,
                        closable: true,
                        onClose: function () {
                            delete tabs[viewId];
                            return true;
                        }
                    });
                    tabs[viewId] = tabContent;
                    this.tabContainer.addChild(tabContent);
                    this.tabContainer.startup();
                }
                this.tabContainer.selectChild(tabs[viewId]);
                return tabContent;
            },
            _createUserMenubarLabel: function (id) {
                var self = this;
                var menuItem = new MenuBarItem({
                    id: id,
                    label: messages["menuBarItem_" + id],
                    onClick: function () {
                        self.emit("clickMenuBarItem_" + id, {});
                    },
                    templateString: '<div class="dijitReset dijitInline dijitMenuItemLabel"\
                         tabIndex = "-1" >\
                    <span data-dojo-attach-point="containerNode,textDirNode"></span> </div>'
                });
                return menuItem;
            },
            _createMenubarButton: function (id) {
                var self = this;
                var menuItem = new MenuBarItem({
                    id: id,
                    label: messages["menuBarItem_" + id],
                    onClick: function () {
                        self.emit("clickMenuBarItem_" + id, {});
                    }
                });
                return menuItem;
            }
        })
            ;
    }
)
;