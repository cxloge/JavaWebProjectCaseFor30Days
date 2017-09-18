function showDiv(id,menu){
	tfpos=getElementPos(id);
	xby=tfpos.y+tfpos.h-2;
	xbx=tfpos.x;
	document.getElementById(menu).style.visibility="visible";
	document.getElementById(menu).style.top=xby;
	document.getElementById(menu).style.left=xbx;
}

function hideDiv(id){
	document.getElementById(id).style.visibility="hidden";
}