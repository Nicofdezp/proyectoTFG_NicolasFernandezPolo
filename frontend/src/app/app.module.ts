import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';

//PRIMENG
import {ButtonModule} from 'primeng/button';
import {InputTextModule} from 'primeng/inputtext';
import {CalendarModule} from 'primeng/calendar';
import {TableModule} from 'primeng/table'

//COMPONENTES
import { AppComponent } from './app.component';
import { SideBarComponent } from './components/side-bar/side-bar.component';
import { ActividadesComponent } from './components/actividades/actividades.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { RegistroComponent } from './components/registro/registro.component';
import { Constantes } from './other/constantes';
import { UsuarioInfoComponent } from './components/usuario-info/usuario-info.component';
import { CrearActividadComponent } from './components/crear-actividad/crear-actividad.component';

@NgModule({
  declarations: [
    AppComponent,
    SideBarComponent,
    ActividadesComponent,
    HomeComponent,
    LoginComponent,
    RegistroComponent,
    UsuarioInfoComponent,
    CrearActividadComponent,
    
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    ButtonModule,
    InputTextModule,
    FormsModule,
    CalendarModule,
    HttpClientModule,
    TableModule
  ],
  providers: [
    Constantes
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
