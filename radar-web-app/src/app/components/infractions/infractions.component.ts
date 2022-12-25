import { Component, OnInit } from '@angular/core';
import { InfractionService } from 'src/app/services/infraction.service';

@Component({
  selector: 'app-infractions',
  templateUrl: './infractions.component.html',
  styleUrls: ['./infractions.component.css']
})
export class InfractionsComponent implements OnInit {

  infractions: any[] = [];
  vehicles!: any[];
  owner!: any;

  constructor(private infractionService:InfractionService) { 
    this.vehicles = history.state.vehicles;
    this.owner = history.state.owner;
  }

  ngOnInit(): void {
    if(this.vehicles == undefined) {
      this.infractionService.getInfractions().subscribe((data: any[]) =>{
          this.infractions = data;
        }
      )
    }
    else{
      this.infractionService.getInfractions().subscribe((data: any[]) =>{
            for(let j=0; j < data.length; j++){  
              for(let i = 0; i < this.vehicles.length; i++) {              
                if(data[j].vehicleMatricule == this.vehicles[i].matricule) {
                  this.infractions.push(data[j]);
                }
              }
            }
          });
      }
    
  }

  deleteInfraction(infraction: any) {
    //
  }
    
  editInfraction(infraction: any) {
    //
  }

}
