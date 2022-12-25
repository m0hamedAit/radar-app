import { Component, OnInit } from '@angular/core';
import { ImmatriculationService } from 'src/app/services/immatriculation.service';

@Component({
  selector: 'app-vehicles',
  templateUrl: './vehicles.component.html',
  styleUrls: ['./vehicles.component.css']
})
export class VehiclesComponent implements OnInit {

  vehicles!: any[];
  owner!: any;
  constructor(private immatriculationService: ImmatriculationService) {
    this.owner = history.state.owner;
   }

  ngOnInit(): void {
    if(this.owner == undefined) {
      this.immatriculationService.getVehicles().subscribe(
        data =>{
          this.vehicles = data;
        }
      )
    }
    else {
      this.immatriculationService.getVehicleByOwner(this.owner.id).subscribe(
        data =>{
          this.vehicles = data;
        }
      )
    }
  }

  deleteVehicle(vehicle: any) {
    //
  }
  
  editVehicle(vehicle: any) {
    //
  }
}
