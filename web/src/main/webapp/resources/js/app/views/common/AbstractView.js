/**
 * User: Alexey Nevinsky
 * Date: 06.07.13 17:36
 */

define([
    "dojo/_base/declare", "dojo/_base/lang", "dojo/Evented",
    "dojo/i18n!nls/messages",
    "dijit/_WidgetBase",
    "dijit/_TemplatedMixin",
    "dijit/_WidgetsInTemplateMixin"
], function (declare, lang, Evented, messages, _WidgetBase, _TemplatedMixin, _WidgetsInTemplateMixin) {
    return declare([_WidgetBase, _TemplatedMixin, Evented, _WidgetsInTemplateMixin], {
        templateString: null,
//        messages: new messages(),
        viewStore: null,
        constructor: function (options) {
            lang.mixin(this, options);
        }

    });

});