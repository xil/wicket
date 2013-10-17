/**
 * Created with IntelliJ IDEA.
 * User: inver
 * Date: 16.10.12
 * Time: 13:37
 * To change this template use File | Settings | File Templates.
 */

define([
    "dojo/_base/declare", "dojo/_base/lang", "dojo/Evented",

    "dijit/_WidgetBase", "dijit/_TemplatedMixin", "dijit/_WidgetsInTemplateMixin", "dojo/text!./user-page.html",

    "dojox/mvc/at", "dojox/mvc/Group", "dojox/mvc/Repeat", "dojox/mvc/Output" , "dijit/form/Button"
], function (declare, lang, Evented, _WidgetBase, _TemplatedMixin, _WidgetsInTemplateMixin, template, at) {
        return declare([_WidgetBase, _TemplatedMixin, _WidgetsInTemplateMixin, Evented], {
            templateString: template,
            model: null,

            constructor: function (options) {
                lang.mixin(this, options);
            }
        });
    }
)
;