import { Component, OnInit } from '@angular/core';
import { Order } from '../../store/order';
import { RiderOrderService } from '../../services/users/rider/order/rider-order.service';
import { RiderService } from 'src/app/services/users/rider/rider.service';
import { Rider } from './rider';
import { LoginService } from 'src/app/services/login/login.service';
import { RiderType } from "../../store/rider-type.enum";
import { LoginResponse } from 'src/app/services/login/dto/login-response';

@Component({
  selector: 'app-rider',
  templateUrl: './rider.component.html',
  styleUrls: ['./rider.component.css']
})
export class RiderComponent implements OnInit {

  constructor(
    private riderService: RiderService,
    private riderOrderService: RiderOrderService,
    private loginService: LoginService) {
  }

  showSummary: boolean;
  showOrder: boolean;
  summaryList: Order[];
  orderList: Order[];
  rider: Rider;
  loginResponse: LoginResponse;

  ngOnInit(): void {
    this.showOrder = false;
    this.showSummary = false;
    this.loginResponse = this.loginService.getLoginResponse();
    this.getRiderType();
  }

  getRiderType() {
    this.riderService.fetchRiderInfo(this.loginResponse.userId).subscribe((data: any)=>{
      console.log(data);
      this.rider = data;
    })
  }

  viewOrder() : void {
    this.showOrder = true;
    this.showSummary = false;
    this.getOrder();
  }

  viewSummary() : void {
    this.showSummary = true;
    this.showOrder = false;
    this.getSummary();
  }

   getOrder(): void {
    let type = RiderType[this.rider.riderType];
    console.log(type);
    if (RiderType[this.rider.riderType] === RiderType.FULL_TIME) {
        /*  this.riderOrderService.fetchFullTimeOrders(this.rider.id).subscribe((data: any[])=>{
          console.log(data);
          this.orderList = data;
        }) */
        const order1: Order = {
        oid: 1,
        totalCost: 1,
        deliveryFee: 1,
        paymentType: "test",
        location: "te",
        orderTime: null,
        deliveryTime: null
      };
      this.orderList = [order1];
    } else {
        /* this.riderOrderService.fetchPartTimeOrders(this.rider.id).subscribe((data: any[])=>{
        console.log(data);
        this.orderList = data;
      }) */
      const order2: Order = {
        oid: 2,
        totalCost: 2,
        deliveryFee: 2,
        paymentType: "test",
        location: "te",
        orderTime: null,
        deliveryTime: null
      };
      this.orderList = [order2];
    }
  }

  getSummary(): void {
    this.riderOrderService.fetchRiderSummary(this.rider.id).subscribe((data: any[])=>{
      console.log(data);
      this.summaryList = data;
    })
  }

}
