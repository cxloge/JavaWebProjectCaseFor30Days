function changeTab(k,n) {
	for(i=1;i<=n;i++) {
		var tab = document.getElementById("tab"+i);
		var con = document.getElementById("con"+i);
		tab.className = k==i?"hover":"";
		con.style.display = k==i?"block":"none";
	}
}