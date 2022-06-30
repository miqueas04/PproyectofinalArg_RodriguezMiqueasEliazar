import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Educacion } from 'src/app/model/educacion';
import { EducacionService } from 'src/app/service/educacion.service';

@Component({
  selector: 'app-educacion',
  templateUrl: './educacion.component.html',
  styleUrls: ['./educacion.component.css']
})
export class EducacionComponent implements OnInit {

  public educaciones:Educacion[]=[];
  public editarEducacion:Educacion | undefined;
  public borrarEducacion:Educacion | undefined;

  constructor(private educacionService:EducacionService) { }

  ngOnInit(): void {
    this.getEducaciones();
  }
public getEducaciones():void{
  this.educacionService.getEducacion().subscribe({
  next:(Response: Educacion[]) =>{
    this.educaciones=Response;
  },
  error:(error:HttpErrorResponse)=>{
    alert(error.message);
  }

  })


}
public onOpenModal(mode:String, educacion?: Educacion):void{
const container=document.getElementById('main-container');
const button=document.createElement('button');
button.style.display='none';
button.setAttribute('data-toggle', 'modal');
if(mode==='add'){
  button.setAttribute('data-target', '#addEducacionModal');
}
 else if(mode==='delete'){
  this.borrarEducacion=educacion;
  button.setAttribute('data-target','#borrarEducacionModal');
}else if(mode==='edit'){
  this.editarEducacion=educacion;
  button.setAttribute('data-target','#editarEducacionModal');
}
container?.appendChild(button);
button.click();

}
public onAddEducacion(addForm: NgForm){
  document.getElementById('add-educacion-form')?.click();
  this.educacionService.addEducacion(addForm.value).subscribe({
    next: (response:Educacion) =>{
      console.log(response);
      this.getEducaciones();
      addForm.reset();
    },
    error:(error:HttpErrorResponse)=>{
      alert(error.message);
      addForm.reset();
    }
  })
}

public onUpdateEducacion(educacion: Educacion){
  this.editarEducacion=educacion;
  document.getElementById('add-educacion-form')?.click();
  this.educacionService.editarEducacion(educacion).subscribe({
    next: (response:Educacion) =>{
      console.log(response);
      this.getEducaciones();
    },
    error:(error:HttpErrorResponse)=>{
      alert(error.message);
      
    }
  })
}
public onDeleteEducacion(idEdu: number):void{
  
  this.educacionService.borrarEducacion(idEdu).subscribe({
    next: (response:void) =>{
      console.log(response);
      this.getEducaciones();
    },
    error:(error:HttpErrorResponse)=>{
      alert(error.message);
      
    }
  })
}
}

