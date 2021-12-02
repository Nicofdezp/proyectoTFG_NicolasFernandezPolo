import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ActividadDetalleComponent } from './components/actividad-detalle/actividad-detalle.component';
import { ActividadesComponent } from './components/actividades/actividades.component';
import { CrearActividadComponent } from './components/crear-actividad/crear-actividad.component';
import { CrearTrabajorComponent } from './components/crear-trabajor/crear-trabajor.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { RegistroComponent } from './components/registro/registro.component';
import { ReservasComponent } from './components/reservas/reservas.component';
import { UsuarioInfoComponent } from './components/usuario-info/usuario-info.component';


const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'home', component: HomeComponent},
  {path: 'actividades', component: ActividadesComponent},
  {path: 'login', component: LoginComponent},
  {path: 'registro', component: RegistroComponent},
  {path: 'usuario', component: UsuarioInfoComponent},
  {path: 'actividades/actividad' , component: ActividadDetalleComponent},
  {path: 'reservas', component: ReservasComponent},
  {path: 'crearActividad', component: CrearActividadComponent},
  {path: 'crearTrabajador', component: CrearTrabajorComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
