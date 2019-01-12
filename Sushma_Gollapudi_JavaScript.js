//Demonstartion of different concepts on java script objects
/*

-Creating Employee object and populating it
-Adding various methods to dispaly employee details and other properties to the employee function's prototype
-Adding a function to calculate the experience on an employee in the company
-Using call function to remove designation of an employee by HR
-Using bind to send greetings to the employee by HR
-Using dunder proto of an example employee to reassign the designation
-creating two other objects managers and devolopers which inherit the object Employee
-Using the inheritance properties, calculating the experience of the Devolpoer
-Using the inheritance properties finding the ctc of the manager

*/

  // function to create Employee 
function Employee(firstname,lastname,padd,tadd,phno,DOB,mailid,YOJ,Age,desg)
{
  this.fname=firstname;
  this.lname=lastname;
  this.address=               //Nesting objects
  {
    permanent:padd, 
    temporary:tadd
  };
  this.phno=phno;
  this.mailid=mailid;
  this.joining_year=YOJ;
  this.DOB=DOB;
  this.designation=desg;
  this.removeDesg=function()
  {
    this.designation="none";
  }
  this.greeting = function(){
    console.log("welcome by "+this.name);
};
}

var emp1=new Employee("sushma","G","Bellari","bangalore","124543","2 apr 1990","abc@abc.com",2010,"28","Devoloper");
 //populating employees
var n=prompt("Enter the number of employees:");
for(var i=0;i<n;i+=1)
{
  alert("Enter the details:");
  var fn=prompt("Enter the first name:");
  var ln=prompt("Enter the last name:");
  var padd=prompt("Enter the permanent address:");
  var tadd=prompt("Enter the temporary address:");
  var d=prompt("Enter the designation");
  var pno=prompt("Enter the phone number");
  var mail=prompt("Enter the mailid");
  var yoj=prompt("Enter the year of joining");
  var age=prompt("ENter the age");
  var dob=prompt("enter the date of birth");
  var empid="emp"+i+2;
  var empid=new Employee(fn,ln,padd,tadd,pno,dob,mail,yoj,age,d);
  console.log("\nDisplay:\n");
  empid.getotherdetails();
}
var otheremp1=new Employee("sclarey","H","Bellari","bangalore","124543","2 apr 1990","abc@abc.com",2010,"28","Manager");
var otheremp2=new Employee("jim","k","Bellari","bangalore","124543","2 apr 1996","ydbc@abc.com",2010,"29","Manager");
var otheremp3=new Employee("joy","l","Bellari","bangalore","124543","2 apr 1999","aab@abc.com",2010,"38","Devoloper");
console.log("\n\n\n");


  //Adding functions in the employee prototype to access common details
Employee.prototype.getname=function()  
 {
    console.log("Name="+this.fname + " " + this.lname);
  }
  //emp1.getname();

Employee.prototype.getaddress=function()
{
  console.log("Permanent Address="+this.address.permanent+"\n");
  console.log("Temporary Address="+this.address.temporary+"\n");
}
  //emp1.getaddress();
  
  //Function to access other basic details of the employee
Employee.prototype.getotherdetails=function()
{
  console.log("Name="+this.fname + " " + this.lname);
  console.log("Permanent Address="+this.address.permanent+"\n");
  console.log("Temporary Address="+this.address.temporary+"\n");
  console.log("phno="+this.phno+"\nmailid="+this.mailid+"\njoining_year="+this.joining_year+"\nDOB="+this.DOB+"\ndesignation="+this.designation+"\n");
}
emp1.getotherdetails();
console.log("\n\n\n");

  //Function to calculate the employee's experience in the company
Employee.prototype.experience=function()
{
  console.log("Experience="+ (2016-this.joining_year));
}
emp1.experience();
console.log("\n\n\n");

  //Dynamically adding account number to the employee function
Employee.prototype.accno=function(acc)
{
  this.accno=acc;
}
emp1.accno("12346789");
console.log("Account no: "+ emp1.accno);
console.log("\n\n\n");


  // usage of call function
  //lets create hr function which can be able to remove the designation of an employee
function hr(name)
{
  this.name=name;
}
var hr1=new hr("Jim");

  //Suppose jim want to remove designation of emp1, we use call function
hr1.removeDesg= emp1.removeDesg;
hr1.removeDesg.call(emp1);
console.log("Designation after removal: "+emp1.designation);
console.log("\n\n\n");

  //usage of dunder proto
  //updating the designation of employee emp1 using its dunder protocol
emp1.__proto__.designation="Devoloper";
console.log("Designation after updation: "+emp1.__proto__.designation);
console.log("\n\n\n");

  //usage of bind function
  //lets say hr wants to greet an employee
emp1.greeting.bind(hr1);
console.log("\n\n\n");


  //Inheritance using multiple objects
  //Lets say we have managers and devolopers under employee

  //function for devolopers
function Devoloper(post,mainskill,client_of,YOJ,current_project)
{
  this.post=post;
  this.mainskill=mainskill;
  this.client=client_of;
  this.project=current_project;
  this.joining_year=YOJ;
}

var d1=new Devoloper("team manager","UI","ebay",2000,"website");
var d2=new Devoloper("team member","angular","ebay",2005,"website");

  //Accessing devolopers experience using function of employee
d1.__proto__.__proto__=Employee.prototype;
console.log(d1.experience());
//similarly any function of employee can be used

  //similarly we can create another inherited object managers
function Manager(name,basic_salary,YOJ)
{
  this.name=name;
  this.basic=basic_salary;
  this.joining_year=YOJ;
}
var m1=new Manager("Charan","20000",2016);

  //creating a calculate salary function in employee
Employee.prototype.calsal=function(){
  return (parseInt(m1.basic)+20000);
}

  //calculating salary of a manager using calsal and experience function of Employee
m1.__proto__.__proto__=Employee.prototype;
console.log("CTC:  "+m1.calsal());
console.log("\n\n\n");

