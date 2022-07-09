import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Usuario } from 'src/app/model/usuario';
import { HeaderService } from 'src/app/service/acerdade.service';
import { AcercaDeComponent } from '../acerca-de/acerca-de.component';

@Component({
  selector: 'app-banner',
  templateUrl: './banner.component.html',
  styleUrls: ['./banner.component.css']
})
export class BannerComponent extends AcercaDeComponent {

  refresh(): void {
    window.location.reload();
}

}
