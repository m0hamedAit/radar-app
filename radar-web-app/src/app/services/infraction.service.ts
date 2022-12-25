import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class InfractionService {

  constructor(private http:HttpClient) {}

  public getInfractions(): any {
    return this.http.get<any>(environment.infraction_query_api + "/allInfractions");
  }

  public getInfraction(id: number): any {
    return this.http.get<any>(environment.infraction_query_api + "/" + id);
  }

  public getInfractionsByVehicle(id: number): any {
    return this.http.get<any>(environment.infraction_query_api + "/vehicle/" + id);
  }

  public getInfractionsByRadar(id: number): any {
    return this.http.get<any>(environment.infraction_query_api + "/radar/" + id);
  }
}
