/**
 * User: Alexey Nevinsky
 * Date: 06.07.13 22:37
 */
define([
    'dojo/i18n!../nls/messages',
    "dojo/_base/declare", "dojo/_base/lang",
    "views/common/AbstractView",

    "dojox/grid/DataGrid"
], function (messages, declare, lang, AbstractView, DataGrid) {
        return declare([AbstractView], {
            grid: null,
            selectedRowId: null,
            i18n: messages,

            postCreate: function () {
                this._initGrid();

                this._initButtons();
                this.inherited(arguments);
            },
            _initButtons: function () {
                this.refreshButton.on("click", lang.hitch(this, function () {
                    this.emit("refresh", {});
                }));
            },
            _initGrid: function () {
                var self = this;
                this.usersGrid.setStore(this.viewStore, "list?");
                this.usersGrid.canSort = function (inSortInfo) {
                    return inSortInfo == 4 ?
                        false : true
                };
                this.usersGrid.on("rowClick", lang.hitch(this, function (e) {
                    this.selectedRowId = e.rowIndex;
                }));
                this.usersGrid.on("rowDblClick", lang.hitch(this, function (e) {
                    this.selectedRowId = e.rowIndex;
                    this.emit("edit", {});
                }));
            },
            _createButtonClick: function (action) {
                this.emit(action, {});
            },
            getSelectedId: function (id) {
                return this.usersGrid.getItem(id).id;
            },
            getSelectedItem: function () {
//                TODO null checking
                return this.usersGrid.getItem(this.selectedRowId);
            },
            refresh: function () {
                this.usersGrid.setQuery({id: "*"});
            }
        });
    }
)
;
