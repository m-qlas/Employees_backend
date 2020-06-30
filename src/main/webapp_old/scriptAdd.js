const form = document.querySelector("form");
const subBtn = document.querySelector("button");


class Alien{
	constructor(aId, aName, aTech, laptops=[]){
		this.aId = aId;
		this.aName = aName;
		this.aTech = aTech;
		this.laptops = laptops;
	}
}

class Laptop{
	constructor(lId, lName,processor, ram) {
		this.lId = lId;
		this.lName = lName;
		this.processor = processor;
		this.ram = ram;
	}
}

validation();
//Checking if all input fields are fullfiled
function validation(){
	"use strict";
	window.addEventListener("load", function() {
		// Get the forms we want to add validation styles to
		var forms = document.getElementsByClassName("needs-validation");
		// Loop over them and prevent submission
		var validation = Array.prototype.filter.call(forms, function(form) {
			subBtn.addEventListener("click", function(event) {
				if (form.checkValidity() === false) {
					event.preventDefault();
					event.stopPropagation();
				}
				else{
					addAlien();
					console.log("form validated");	
				}
				form.classList.add("was-validated");
				getFormData();
				//setTimeout(addAlien(),100);
			}, false);
		});
	}, false);
}

async function addAlien(){
	console.log("Adding started");
	
	let laps = [];
	let lap = new Laptop(form.querySelector("#lId").value,
		form.querySelector("#lName").value,
		form.querySelector("#processor").value,
		form.querySelector("#ram").value
	);	
	
	laps.push(lap);
	let alien = new Alien(form.querySelector("#aId").value,
		form.querySelector("#aName").value,
		form.querySelector("#aTech").value, laps);
		
	const response = await fetch("app/alien", {
		method: "POST",
		headers: {"Content-Type": "application/json"},
		body: JSON.stringify(alien)
	});
	
	let resText = document.createElement("p");
	resText.textContent = "Alien added to Database!";		
	$(".container").last().append(resText);
	return response.json;
}

// function getFormData(){
// 	// Display the key/value pairs
// 	for(var pair of fd.entries()) {
// 		console.log(pair[0]+ " : "+ pair[1]); 
// 	}
// }

//Sending alien to the server

//const cont = document.querySelector(".container");

// function addAlien(){
// 	console.log("function started");
// 	form.addEventListener("submit", ()=>{
// 		console.log("Adding started");
// 		if(form.classList.contains("was-validated")) {
// 			console.log("Adding step 2");
// 			let fd = new FormData(form);
// 			let xhr = new XMLHttpRequest();
			
// 			xhr.responseType = "json";
// 			xhr.open("POST", "app/alien");
// 			xhr.setRequestHeader("Content-Type", "application/json");
// 			xhr.send(JSON.stringify(Object.fromEntries(fd)));
// 			xhr.onload = ()=>{
// 				let resText = document.createElement("p");
// 				resText.textContent = "Alien added to Database!";		
// 				$(".container").last().append(resText);
// 			};
// 		}
// 		else{console.log("Adding failed");}
// 	});
	
// };


// Adding alien
 
//function addAlien(){
// 	console.log("Adding started");
// 	fd = new FormData(form);
// 	let xhr = new XMLHttpRequest();
// 	xhr.responseType = "json";
// 	xhr.open("POST", "app/alien");
// 	xhr.setRequestHeader("Content-Type", "application/json");
// 	xhr.send(JSON.stringify(Object.fromEntries(fd)));
// 	xhr.onload = ()=>{
// 		let resText = document.createElement("p");
// 		resText.textContent = "Alien added to Database!";		
// 		$(".container").last().append(resText);
// 	};
// };
