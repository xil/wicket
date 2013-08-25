/**
 * User: Alexey Nevinsky
 * Date: 06.07.13 22:37
 */
define([
    "dojo/_base/declare",
    "views/common/AbstractView",

    "dojox/grid/DataGrid"
], function (declare, AbstractView, DataGrid) {
        return declare([AbstractView], {
            grid: null,

            postCreate: function () {
                this.inherited(arguments);

                this._initGrid();
                this._initButtons();
            },
            _initButtons: function () {
                this.connect(this.createButton, "onClick", "createButtonClick");
            },
            _initGrid: function () {
                var self = this;
//                this.usersGrid.set('structure',
//                    {name: "Id", field: 'id', width: '40%'},
//                    {name: "Version", field: 'version', width: '60%'});
                this.usersGrid.setStore(this.viewStore);

//                var gridArgs = {
//                    store: new ObjectStore({objectStore: self.viewStore}),
//                    structure: [
//                        {name: messages.userBrowser_userGrid_username, field: 'username', width: '40%'},
//                        {name: "Id", field: 'id', width: '40%'},
//                        {name: "Version", field: 'version', width: '60%'}
//                    ]
//                };
//
//                this.grid = new DataGrid(gridArgs, "tableContentPane");
//                this.grid.startup();

            },
            createButtonClick: function () {
                this.emit("create", {});
            }
        });
    }
)
;