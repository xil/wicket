/**
 * User: Alexey Nevinsky
 * Date: 06.07.13 22:37
 */
define([
    'dojo/i18n!../nls/messages',
    "dijit/Dialog",

    "dojo/_base/declare",
    "dojo/_base/lang",
    "dojo/Evented",

    "dojox/mvc/Group",

    "views/common/AbstractView",
    "dijit/form/Form", "dijit/form/ValidationTextBox"
], function (messages, Dialog, declare, lang, Evented, Group, AbstractView) {
    return declare([Dialog, Evented], {

        constructor: function (options) {
            lang.mixin(this, options);

            var initParams = this.contentParams;

            this.ctrl = initParams.ctrl;
            this.title = this.ctrl.itemId ? messages.editExistUser : messages.editNewUser;
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
            var applyButton = this.content.applyButton;
            this.connect(applyButton, "onClick", "apply");

            var scanningButton = this.content.scanningButton;
            this.connect(scanningButton, "onClick", "scanning");
            scanningButton.set("disabled", !this.contentParams.scanningEnabled);
        },
        commit: function () {
//            TODO check validation
            if (this.content.form.validate()) {
                this.emit("commitAction", {});
            }
        },
        cancel: function () {
            this.emit("closeAction", {});
        },
        apply: function () {
            //            TODO check validation
            if (this.content.form.validate()) {
                this.emit("applyAction", {});
            }
        },
        scanning: function () {
            this.emit("scanningAction", {});
        },
        enableScanning: function () {
            this.contentParams.scanningEnabled = true;
            this.content.scanningButton.set("disabled", !this.contentParams.scanningEnabled);
        }
    });
});