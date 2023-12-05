import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { MatTableModule } from '@angular/material/table';
import { MatSortModule } from '@angular/material/sort';
import { MatPaginatorModule } from '@angular/material/paginator';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './pages/login/login.component';
import { HomeAdmiComponent } from './pages/home-admi/home-admi.component';
import { HomeStudentComponent } from './pages/home-student/home-student.component';
import { HomeTeacherComponent } from './pages/home-teacher/home-teacher.component';
import { AdminProgramasComponent } from './pages/admin-programas/admin-programas.component';
import { CrearProgramaComponent } from './pages/crear-programa/crear-programa.component';
import { EditarProgramaComponent } from './pages/editar-programa/editar-programa.component';
import { AgregarMateriaComponent } from './pages/agregar-materia/agregar-materia.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeAdmiComponent,
    HomeStudentComponent,
    HomeTeacherComponent,
    AdminProgramasComponent,
    CrearProgramaComponent,
    EditarProgramaComponent,
    AgregarMateriaComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    MatTableModule,
    MatSortModule,
    MatPaginatorModule,
  ],
  providers: [
    provideClientHydration()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
