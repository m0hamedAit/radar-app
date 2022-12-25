import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class RadarService {

  constructor(private http:HttpClient) {}

  public getRadars(){
    return this.http.get<any>(environment.radar_query_api + '/allRadars');
  }

  public getRadar(id: number){
    return this.http.get<any>(environment.radar_query_api + '/' + id);
  }

}
