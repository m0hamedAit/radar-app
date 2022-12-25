import { Component, OnInit } from '@angular/core';
import { RadarService } from 'src/app/services/radar.service';

@Component({
  selector: 'app-radars',
  templateUrl: './radars.component.html',
  styleUrls: ['./radars.component.css']
})
export class RadarsComponent implements OnInit {

  radars!: any[];

  constructor(private radarService: RadarService) { }

  ngOnInit(): void {
    this.radarService.getRadars().subscribe(
      data =>{
        this.radars = data;
      }
    )
  }

  deleteRadar(radar: any) {
    //
  }
    
  editRadar(radar: any) {
    //
  }

}
