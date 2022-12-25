import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { OwnersComponent } from './components/owners/owners.component';
import { VehiclesComponent } from './components/vehicles/vehicles.component';
import { RadarsComponent } from './components/radars/radars.component';
import { InfractionsComponent } from './components/infractions/infractions.component';

const routes: Routes = [
  { path: '', redirectTo: '/radars', pathMatch: 'full' },
  { path: 'owners', component: OwnersComponent },
  { path: 'vehicles', component: VehiclesComponent },
  {path: 'radars', component: RadarsComponent },
  {path: 'infractions', component: InfractionsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule { }
