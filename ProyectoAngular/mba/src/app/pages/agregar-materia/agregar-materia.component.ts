import { Component, ElementRef, ViewChild } from '@angular/core';
import { Materia } from '../../interfaces/materia';
import { AdminProgramasService } from '../../services/admin-programas.service';
import { Router } from '@angular/router';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-agregar-materia',
  templateUrl: './agregar-materia.component.html',
  styleUrl: './agregar-materia.component.css'
})
export class AgregarMateriaComponent {
  public codigo: string; 
  public nombre: string;
  public descripcion: string;
  public semester: string; 
  public fechaI: string;
  public fechaF: string;
  
  public materiaVacia: Materia = {
    codigoDocente: 0,
    codigoMateria: '',
    nombre: '',
    descripcion: '',
    semestre: '',
    fechaInicio: '',
    fechaFinal: ''
  };

  
  @ViewChild('codeInput')
  codeInput!: ElementRef<HTMLInputElement>; 
  @ViewChild('nameInput')
  nameInput!: ElementRef<HTMLInputElement>;
  @ViewChild('descInput')
  descInput!: ElementRef<HTMLInputElement>;  
  @ViewChild('semesterInput')
  semesterInput!: ElementRef<HTMLInputElement>;
  @ViewChild('fInicioInput')
  fInicioInput!: ElementRef<HTMLInputElement>;
  @ViewChild('fFinalInput')
  fFinalInput!: ElementRef<HTMLInputElement>;

  constructor(private programService: AdminProgramasService, private router: Router){
    this.codigo = '';
    this.nombre = '';
    this.descripcion = '';
    this.fechaI = '';
    this.fechaF = '';
    this.semester = '';
    this.materiaVacia ;
  }

  click() {
    this.codigo = this.codeInput.nativeElement.value;
    this.nombre = this.nameInput.nativeElement.value;
    this.descripcion = this.descInput.nativeElement.value;
    this.semester = this.semesterInput.nativeElement.value;
    this.fechaI = this.fInicioInput.nativeElement.value;
    this.fechaF = this.fFinalInput.nativeElement.value;
    if (this.codigo !== '' && this.nombre !== '' && this.descripcion !== '') {
        this.getPost();
    } else {
      alert('Llena todos los campos por favor');
    }
  }
  crearMateria(){
    const programaData = {
        codigoDocente: '',
        codigoMateria: this.codigo,
        nombre: this.nombre,
        descripcion: this.descripcion,
        semestre: this.semester,
        fechaInicio: this.fechaI,
        fechaFinal: this.fechaF
    };

    return programaData
  
  }
  getPost(){
    console.log('entré');
    this.programService.createMateria(this.crearMateria())
      .subscribe((materia: Materia | null) => {
        if (materia === null) {
          alert('No se pudo agregar la materia');
        }
        else {
          this.materiaVacia = materia;
          console.log(materia);
          console.log('Revisar cargo');
          alert('Creado Correctamente');
        }
      });
      return this.materiaVacia
  }

  back(){
    this.router.navigate(['/adminProgramas']);
  }

}

