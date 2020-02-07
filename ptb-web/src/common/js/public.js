// import Layout from '../../views/layout/Layout'
//
// export function getCurrentDate() {
//   var date = new Date()
//   var year = date.getFullYear()
//   var month = date.getMonth() + 1
//   var strDate = date.getDate()
//   var hours = date.getHours()
//   var minutes = date.getMinutes()
//   var seconds = date.getSeconds()
//   if (month >= 1 && month <= 9) {
//     month = '0' + month
//   }
//   if (strDate >= 0 && strDate <= 9) {
//     strDate = '0' + strDate
//   }
//   return year + '-' + month + '-' + strDate + ' ' + hours + ':' + minutes + ':' + seconds
// }
//
//
// // date.js
// export function formatDate(date, fmt) {
//   if (/(y+)/.test(fmt)) {
//     fmt = fmt.replace(RegExp.$1, (date.getFullYear() + '').substr(4 - RegExp.$1.length));
//   }
//   let o = {
//     'M+': date.getMonth() + 1,
//     'd+': date.getDate(),
//     'h+': date.getHours(),
//     'm+': date.getMinutes(),
//     's+': date.getSeconds()
//   };
//   for (let k in o) {
//     if (new RegExp(`(${k})`).test(fmt)) {
//       let str = o[k] + '';
//       fmt = fmt.replace(RegExp.$1, (RegExp.$1.length === 1) ? str : padLeftZero(str));
//     }
//   }
//   return fmt;
// }
//
// function padLeftZero(str) {
//   return ('00' + str).substr(str.length);
// }
//
// export function str2Date(dateStr, separator) {
//   if (!separator) {
//     separator = "-";
//   }
//   let dateArr = dateStr.split(separator);
//   let year = parseInt(dateArr[0]);
//   let month;
//   //处理月份为04这样的情况
//   if (dateArr[1].indexOf("0") == 0) {
//     month = parseInt(dateArr[1].substring(1));
//   } else {
//     month = parseInt(dateArr[1]);
//   }
//   let day = parseInt(dateArr[2]);
//   let date = new Date(year, month - 1, day);
//   return date;
// }
//

export function fieldIsNull(field) {
  return typeof(field) == "undefined" || field == null
}
//
//
// function menu.name{
//   let naLan = window.navigator.language;
//   if(naLan =='en' || naLan.indexOf("en-") >= 0){
//     return  menu.nameEn;
//   }else if(naLan =='es' || naLan.indexOf("es-") >= 0){
//     return  menu.nameEs;
//   }else if(naLan =='zh' || naLan.indexOf("zh-") >= 0){
//     return  menu.name;
//   }else{
//     return  menu.name;
//   }
// }
//
// export function menuRender(menu){
//   if(fieldIsNull(menu.children)){
//     return {path:menu.path, component:menu.component, redirect:menu.redirect,name:menu.name, hidden:menu.hidden == 0 ? false: true, meta:{title:menu.name,icon:menu.icon}}
//   }
//   let tmpMenu = null;
//     tmpMenu = menu.component == 'layout' ? {path:menu.path, component:"Layout", redirect:menu.redirect,name:menu.name, hidden:menu.hidden == 0 ? false: true, meta:{title:menu.name,icon:menu.icon},children:[]}
//                                          : {path:menu.path, component:"Layout", redirect:menu.redirect,name:menu.name, hidden:menu.hidden == 0 ? false: true, meta:{title:menu.name,icon:menu.icon},children:[]}
//   for(let i = 0 ; i< menu.children.length; i ++ ){
//     tmpMenu.children.push(menuRender(menu.children[i]));
//   }
//   return tmpMenu
// }
