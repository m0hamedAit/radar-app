import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ImmatriculationService {

  constructor(private http:HttpClient) { }

  public getOwners(){
    return this.http.get<any>(environment.immatriculation_query_api + '/owner/allOwners');
  }

  public getOwner(id: number){
    return this.http.get<any>(environment.immatriculation_query_api + '/owner/' + id);
  }

  public getVehicles(){
    return this.http.get<any>(environment.immatriculation_query_api + '/vehicle/allVehicles');
  }

  public getVehicleByPlate(plate: string){
    return this.http.get<any>(environment.immatriculation_query_api + '/vehicle/matricule' + plate);
  }

  public getVehicle(id: number){
    return this.http.get<any>(environment.immatriculation_query_api + '/vehicle/' + id);
  }

  public getVehicleByOwner(id: number){
    return this.http.get<any>(environment.immatriculation_query_api + '/vehicles/' + id);
  }
  
}
