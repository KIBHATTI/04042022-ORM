import { Component, OnInit } from '@angular/core';
import { Payee } from './Payee';

@Component({
  selector: 'app-addpayee',
  templateUrl: './addpayee.component.html',
  styleUrls: ['./addpayee.component.css']
})
export class AddpayeeComponent implements OnInit {

  errMsg: string="";
  tempAccountNumber: number=0;
  payeeObj: Payee = new Payee();
  payeeArray: Payee[]=[
    {payeeId:1,payeeAccountNumber:12121,payeeName:"Sarah Solverson",payeeIFSCCode:"SBIN0003531",payeeNickName:"Sara"},
    {payeeId:2,payeeAccountNumber:12122,payeeName:"Jonnathan",payeeIFSCCode:"SBIN0003931",payeeNickName:"Jon"},
    {payeeId:3,payeeAccountNumber:12123,payeeName:"Michael",payeeIFSCCode:"SBIN0000644",payeeNickName:"Mike"},
    {payeeId:4,payeeAccountNumber:12124,payeeName:"Monica",payeeIFSCCode:"SBIN0002663",payeeNickName:"Mon"}
  ];
  constructor() { }
  
  ngOnInit(): void {
  }
  verifyAccountNumber()
  {
    if(this.payeeObj.payeeAccountNumber != this.tempAccountNumber)
    {
      this.errMsg="Account number does not match";
    }else
      this.errMsg="";
  }
  addPayee()
  {
      this.payeeArray.push(this.payeeObj);
  }
  deletePayee(payeeToBeDeleted:Payee)
  {
    console.log("Deleting Payee");
    this.payeeArray=this.payeeArray.filter(item=>item!==payeeToBeDeleted);
    console.log("deleted Payee "+this.payeeArray);
    
  }

  tempPayeeArray: Payee[]= this.payeeArray;
  tempPayeeArray2: Payee[]= this.payeeArray;

  reloadPayees(payeeFound: Payee)
  {
    this.tempPayeeArray=this.tempPayeeArray2;
    console.log(payeeFound.payeeName+"Payee Name");
    console.log(this.payeeArray);
    this.tempPayeeArray=this.tempPayeeArray.filter(item=>item.payeeName.match(payeeFound.payeeName));
    this.payeeArray=this.tempPayeeArray;
  }
}
