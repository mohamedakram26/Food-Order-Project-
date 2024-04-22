import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgbCarouselConfig } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss'],
  providers:[NgbCarouselConfig]
})
export class HomePageComponent implements OnInit{

  logo:string="../../../assets/images/banner4.jpeg";

  images=[
    '../../../assets/images/banner1.jpg',
    '../../../assets/images/banner2.jpg',
    '../../../assets/images/banner3.jpg'
  ];

  constructor(
    config:NgbCarouselConfig,
    private route:Router
  ){
    config.interval=2000;
    config.keyboard=false;
    config.pauseOnHover=false;
  }

  ngOnInit(): void {
    
  }

  gotoLogin():void{
    this.route.navigate(['/customer-login'])
  }
} 
