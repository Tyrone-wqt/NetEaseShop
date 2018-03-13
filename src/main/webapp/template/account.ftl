<!DOCTYPE html>
<html>
<#include "/include/head.ftl">
<body>
<#include "/include/support.ftl">
<#include "/include/header.ftl">
<#assign total = 0>
<div class="g-doc">
    <div class="m-tab m-tab-fw m-tab-simple f-cb">
        <h2>已购买的内容</h2>
    </div>
    <#if !orderList?? || !orderList?has_content>
    <div class="n-result">
        <h3>暂无内容！</h3>
    </div>
    <#else>
    <table class="m-table m-table-row n-table g-b3">
        <colgroup><col class="img"/><col/><col class="time"/><col class="price"/></colgroup>
        <thead>
            <tr><th>内容图片</th><th>内容名称</th><th>购买时间</th><th>购买价格</th><th>购买数量</th></tr>
        </thead>
        <tbody>
            <#list orderList as x>
            <#assign total = total + x.price*x.count>
            <tr>
                <td><a href="/show?id=${x.content.id}"><img src="${x.content.cImgUrl}" alt=""></a></td>
                <td><h4><a href="/show?id=${x.content.id}">${x.content.cTitle}</a></h4></td>
                <td><span class="v-time">${x.date}</span></td>
                <td><span class="v-unit">¥</span><span class="value">${x.price}</span></td>
                <td><span class="value">${x.count}</span></td>
            </tr>
            </#list>
        </tbody>
        <tfoot>
            <tr>
                <td colspan="3"><div class="total">总计：</div></td>
                <td><span class="v-unit">¥</span><span class="value">${total}</span></td>
            </tr>
        </tfoot>
    </table>
    </#if>
</div>
<#include "/include/footer.ftl">
</body>
</html>