/**
 * User: Alexey Nevinsky
 * Date: 06.07.13 22:37
 */
define([
    "dojo/_base/declare", "dojo/_base/lang",
    "views/common/AbstractView"
    , "dijit/Dialog", "dojox/mvc/Group", "dijit/form/TextBox"
], function (declare, lang, AbstractView, Dialog, Group, TextBox) {
    return declare([Dialog], {

        constructor: function (options) {
            lang.mixin(this, options);

            var initParams = this.contentParams;
            this.ctrl = initParams.ctrl;
            var contentWidget = new (declare([AbstractView],
                {
                    templateString: initParams.templateString,
                    ctrl: initParams.ctrl
                }
            ));
            contentWidget.startup();
            var content = this.content = contentWidget;
        },
        postCreate: function () {
            this.inherited(arguments);

            var commitButton = this.content.commitButton;
            this.connect(commitButton, "onClick", "commit");
            commitButton.set("label", "Commit");
            var cancelButton = this.content.cancelButton;
            this.connect(cancelButton, "onClick", "cancel");

//                var self = this;
//                var contentWidget = new (declare([AbstractView],
//                    {
//                        templateString: self.templateString
//                    }
//                ));
//                contentWidget.startup();
//                var content = this.content = contentWidget;

        },
        commit: function () {
            this.ctrl.commit();
            this.hide();
        },
        cancel: function () {
            this.hide();
        }
    });
});