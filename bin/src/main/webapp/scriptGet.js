
//Getting selected Alien from Database
const para = document.createElement("p");
const getBtn = document.querySelector("button");
const in1 = document.querySelector("input");
const res = document.querySelector(".result");
const bar = document.querySelector("#bar");
const btn2 = document.querySelector("#a");
const tab1 = document.querySelector("table");
const tab2 = document.querySelector("#lap");
let tabButtons;
let alien;

in1.focus();
in1.addEventListener("keyup", (event)=>{
	if(event.keyCode===13){
		getBtn.click();
	}
});
getBtn.addEventListener("click",()=>{
	if(in1.value === ""){getAliens();}
	else{getAlien();}
} );


//Function to get selected Alien
function getAlien(){
	fetch("app/alien/" + in1.value)
		.then(function (response) {
			response.json()
				.then(function (json) {
					alien=json;
					while(tab1.rows.length>1) {tab1.deleteRow(tab1.rows.length-1);}
					while(tab2.rows.length>1) {tab2.deleteRow(tab2.rows.length-1);}
					$(".result p").remove();
					bar.style.width = "0%";
					setTimeout(()=>{
						if(json.aId === 0) {
							$(".result").append("<p>Wrong input</p>");
							bar.className = "progress-bar progress-bar-striped bg-danger";
							bar.style.width = "100%";
						}
						else{
							bar.className = "progress-bar progress-bar-striped bg-success";
							bar.style.width = "100%";
							let delBtn=[];
							let row = tab1.tBodies[0].insertRow(-1);
							delBtn.push([document.createElement("button"),json.aId]);
							delBtn[0][0].textContent = "Delete";
							delBtn[0][0].className = "btn btn-outline-danger";
							for(let i=0; i<4;i++){row.insertCell(-1);}
							let cells = row.querySelectorAll("td");
							cells[0].append(json.aId);
							cells[1].append(json.aName);
							cells[2].append(json.aTech);
							cells[3].append(delBtn[0][0]);
							for(let i=0; i<json.laptops.length;i++){
								let row2 = tab2.tBodies[0].insertRow(-1);
								for(let j=0;j<4;j++){row2.insertCell(-1);}
								let cells2 = row2.querySelectorAll("td");
								cells2[0].append(json.laptops[i].lId);
								cells2[1].append(json.laptops[i].lName);
								cells2[2].append(json.laptops[i].processor);
								cells2[3].append(json.laptops[i].ram);
							}
							deleteAlien(delBtn);
						}	
					},500);
				});
		});
}		

//Function to get all Aliens
function getAliens(){
	fetch("app/aliens")
		.then(function (response) {
			response.json()
				.then(function (json) {
					while(tab1.rows.length>1) {
						tab1.deleteRow(tab1.rows.length-1);
					}
					$(".result p").remove();
					bar.style.width = "0%";
					setTimeout(()=>{
						bar.className = "progress-bar progress-bar-striped bg-success";
						bar.style.width = "100%";
						let delBtns =[];
						for(let i=0; i<json.length;i++){
							let row = tab1.tBodies[0].insertRow(-1);
							delBtns.push([document.createElement("button"),json[i].aId]);
							
							delBtns[i][0].textContent = "Delete";
							delBtns[i][0].className = "btn btn-outline-danger";
							
							for(let j=0;j<4;j++){row.insertCell(-1);}
							
							let cells = row.querySelectorAll("td");
							cells[0].append(json[i].aId);
							cells[1].append(json[i].aName);
							cells[2].append(json[i].aTech);
							cells[3].append(delBtns[i][0]);
						}
						deleteAlien(delBtns);
					},500);
					
				});
		});
}

//Deleting selected Alien from the table
function deleteAlien(tab){
	for(let i=0; i<tab.length; i++) {
		tab[i][0].addEventListener("click",()=>{
			let xhr = new XMLHttpRequest();
			let id = tab[i][1];
			console.log("Deleting Alien with ID: " + id); 
			xhr.open("Delete", "app/alien/"+id);
			xhr.send();
			xhr.onload = ()=>{
				getBtn.click();
			};
		});
	}
}

