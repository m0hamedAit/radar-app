import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { OwnersComponent } from './components/owners/owners.component';
import { VehiclesComponent } from './components/vehicles/vehicles.component';
import { RadarsComponent } from './components/radars/radars.component';
import { InfractionsComponent } from './components/infractions/infractions.component';
import { AppRoutingModule } from './app-routing.module';
import {MenubarModule} from 'primeng/menubar';
import {MenuItem} from 'primeng/api';
import {HttpClientModule} from '@angular/common/http';
import {TableModule} from 'primeng/table';
import {ButtonModule} from 'primeng/button';
import {ListboxModule} from 'primeng/listbox';
import { FormsModule } from '@angular/forms';
import {BadgeModule} from 'primeng/badge';
import { TagModule } from 'primeng/tag';



@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    OwnersComponent,
    VehiclesComponent,
    RadarsComponent,
    InfractionsComponent, 
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule, 
    MenubarModule,
    TableModule, 
    ButtonModule, 
    ListboxModule,
    FormsModule,
    BadgeModule,
    TagModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
