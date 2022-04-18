import { Component, OnInit } from '@angular/core';
import { AppComponent } from '../app.component';
import { Applicant } from './Applicant';


@Component({
  selector: 'app-applicant',
  templateUrl: './applicant.component.html',
  styleUrls: ['./applicant.component.css']
})
export class ApplicantComponent implements OnInit {

  errorMsg: String="";
  appObj: Applicant = new Applicant();
  appArray: Applicant[] =[
      {applicantId:123,applicantName:"Jeewan",applicantStatus:"Applied",accountappliedfor:"Current"},
      {applicantId:124,applicantName:"Alex",applicantStatus:"Applied",accountappliedfor:"Savings"},
      {applicantId:125,applicantName:"Money",applicantStatus:"Applied",accountappliedfor:"Current"},
      {applicantId:126,applicantName:"Trooper",applicantStatus:"Applied",accountappliedfor:"Current"},
      {applicantId:127,applicantName:"Susan",applicantStatus:"Applied",accountappliedfor:"Savings"},
 ];
  ngOnInit(): void {
  }

  rejectApplication(appToDelete:Applicant)
  {
    console.log("Reject Application method");
    this.appArray=this.appArray.filter(item=>item!==appToDelete);
    this.errorMsg="incomplete file";
    console.log("deleted");
  }
  acceptApplication(appToAccept:Applicant)
  {
    console.log("in Accept Method");
    //appObj.applicantStatus="Accepted"
    appToAccept.applicantStatus="Accepted";
    this.errorMsg="Application for " + appToAccept.applicantName+" accepted";
  }
  addNewApplicant()
  {
    console.log("in add new applicant");
    console.log(this.appObj.applicantId);
    this.appArray.push(this.appObj);
  }
}
