import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ImmatriculationService } from 'src/app/services/immatriculation.service';

@Component({
  selector: 'app-owners',
  templateUrl: './owners.component.html',
  styleUrls: ['./owners.component.css']
})
export class OwnersComponent implements OnInit {

  owners!: any[];

  constructor(private immatriculationService: ImmatriculationService, private router:Router, private http:HttpClient) { }

  ngOnInit(): void {
    this.immatriculationService.getOwners().subscribe(
      data =>{
        this.owners = data;
      }
    )
  }

  showInfractions(owner: any) {

    this.immatriculationService.getVehicleByOwner(owner.id).subscribe(
      data =>{
        this.router.navigate(['/infractions'], { state: { owner: owner ,vehicles: data }});
      }
    )
  }
    
  showVehicle(owner: any) {
     this.router.navigate(['/vehicles'], { state: { owner: owner }});
  }

  deleteOwner(owner: any) {
    //
  }
    
  editOwner(owner: any) {
    //
  }

}
