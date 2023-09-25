// JS
var idx = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ'.split('');
var tmp = "";
for (var i=0; i < pwd.length; i++)
    tmp += " "+idx.indexOf(pwd.charAt(i));

if(tmp == " 40 2 6 6 3 13 14 7 2 0 36 39 1 6 37 4 11 15 7 0")
{
    $.post('/jobs/challenge/submit', {pwd: pwd}).always(function(x) { window.location = '/jobs/challenge/next'});
}
