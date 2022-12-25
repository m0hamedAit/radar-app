import { Component, OnInit } from '@angular/core';
import { MenuItem } from 'primeng/api';
import {Router} from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private router:Router ) { }

  items!: MenuItem[];

  ngOnInit() {
      this.items = [
          {
              label:'Radars',
              icon:'pi pi-fw pi-video',
              items:[
                  {
                      label:'New',
                      icon:'pi pi-fw pi-plus',
                  },
                  {
                      label:'List',
                      icon:'pi pi-fw pi-list',
                      command: (event) => {   this.router.navigate(['radars']);
                    }
                  },
                  
              ]
          },
          
          {
              label:'Owners',
              icon:'pi pi-fw pi-user',
              items:[
                  {
                      label:'New',
                      icon:'pi pi-fw pi-user-plus',

                  },
                  {
                      label:'List',
                      icon:'pi pi-fw pi-list',
                      command: (event) => {    this.router.navigate(['owners']);}
                  },
                  {
                      label:'Search',
                      icon:'pi pi-fw pi-users',
                  }
              ]
          },
          {
            label:'Vehicles',
            icon:'pi pi-fw pi-car',
            items:[
                {
                    label:'New',
                    icon:'pi pi-fw pi-user-plus',

                },
                {
                    label:'List',
                    icon:'pi pi-fw pi-list',
                    command: (event) => {    this.router.navigate(['vehicles']);}
                },
                {
                    label:'Search',
                    icon:'pi pi-fw pi-users',
                }
            ]
        },
          {
            label:'Infractions',
            icon:'pi pi-fw pi-info-circle',
            command: (event) => { this.router.navigate(['infractions']);}
        },
          
      ];
  }

}
