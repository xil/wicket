/**
 * User: Alexey Nevinsky
 * Date: 06.07.13 22:37
 */
define([
    "dijit/Dialog",

    "dojo/_base/declare",
    "dojo/_base/lang",
    "dojo/Evented",

    "dojox/mvc/Group",

    "views/common/AbstractView",
    "dijit/form/Form", "dijit/form/ValidationTextBox"
], function (Dialog, declare, lang, Evented, Group, AbstractView) {
    return declare([Dialog, Evented], {

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
        },
        commit: function () {
//            TODO check validation
            if (this.content.form.validate()) {
                this.emit("commitAction", {});
            }
        },
        cancel: function () {
            this.emit("closeAction", {});
        }
    });
});