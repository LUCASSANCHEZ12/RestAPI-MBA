import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { MatTableModule } from '@angular/material/table';
import { MatSortModule } from '@angular/material/sort';
import { MatPaginatorModule } from '@angular/material/paginator';
import { FormsModule, ReactiveFormsModule } from '@angular/forms'; 
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
import { ProfileComponent } from './pages/profile/profile.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CrudUserComponent } from './pages/crud-user/crud-user.component';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { UserAddEditComponent } from './pages/user-add-edit/user-add-edit.component';
import { MatDialogModule } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { DatePipe } from '@angular/common';
import { CustomSnackbarComponent } from './pages/custom-snackbar/custom-snackbar.component';
import { CrearCasosEstudioComponent } from './pages/crear-editar-casos-estudio/crear-casos-estudio.component';
import { VerCasosEstudioComponent } from './pages/ver-casos-estudio/ver-casos-estudio.component';
import { CasosEstudiantesComponent } from './pages/casos-estudiantes/casos-estudiantes.component';
import { MateriasEstudianteComponent } from './pages/materias-estudiante/materias-estudiante.component';
import { SolucionCasoEstudianteComponent } from './pages/solucion-caso-estudiante/solucion-caso-estudiante.component';
import { MateriasDocenteComponent } from './pages/materias-docente/materias-docente.component';
import { CasosDocentesComponent } from './pages/casos-docentes/casos-docentes.component';
import { SolucionCasoDocenteComponent } from './pages/solucion-caso-docente/solucion-caso-docente.component';
import { CalificarSolucionComponent } from './pages/calificar-solucion/calificar-solucion.component';
import { UserStudyCaseComponent } from './pages/user-study-case/user-study-case.component';
import { UserAddStudyCaseComponent } from './pages/user-add-study-case/user-add-study-case.component';
import { MatCheckboxModule } from '@angular/material/checkbox';

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
    ProfileComponent,
    CrudUserComponent,
    UserAddEditComponent,
    CustomSnackbarComponent,
    CrearCasosEstudioComponent,
    VerCasosEstudioComponent,
    CasosEstudiantesComponent,
    MateriasEstudianteComponent,
    SolucionCasoEstudianteComponent,
    MateriasDocenteComponent,
    CasosDocentesComponent,
    SolucionCasoDocenteComponent,
    CalificarSolucionComponent,
    UserStudyCaseComponent,
    UserAddStudyCaseComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    MatTableModule,
    MatSortModule,
    MatPaginatorModule,
    BrowserAnimationsModule,
    FormsModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    MatDialogModule,
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
    ReactiveFormsModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatCheckboxModule
  ],
  providers: [
    provideClientHydration(),
    DatePipe
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
