import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './component/home/home.component';
import { SearchComponent } from './component/search/search.component';
import {BookComponent} from './component/book/book.component';
import {YourbooksComponent} from './component/yourbooks/yourbooks.component';
const routes: Routes = [
  {path: 'home',component: HomeComponent},
  {path:'search',component:SearchComponent},
  {path: '',redirectTo: '/home',pathMatch:'full'},
  {path:'book/:id',component:BookComponent},
  {path:'yourbooks',component:YourbooksComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
