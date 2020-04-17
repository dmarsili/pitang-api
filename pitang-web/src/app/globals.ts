import { Injectable } from '@angular/core';

@Injectable()
export  class Globals {
  public static message_error_generic: string = "Ops! Something wrong! Try again";
  //User
  public static message_error_user_save: string = "Ops! Something wrong with user save! Try again";
  public static message_error_user_list: string = "Ops! Something wrong with user list! Try again";
  public static message_error_user_delete: string = "Ops! Something wrong with user delete! Try again";
  //Car
  public static message_error_car_save: string = "Ops! Something wrong with car save! Try again";
  public static message_error_car_list: string = "Ops! Something wrong with car list! Try again";
  public static message_error_car_delete: string = "Ops! Something wrong with car delete! Try again";
  //Register
  public static message_error_reg_save: string = "Ops! Something wrong with register save! Try again";
  //Login
  public static message_error_login: string = "Ops! Something wrong with login! Try again";
  public static message_error_login_reg: string = "Ops! Something wrong with login! Try again or register new user";
  //Logout
  public static message_error_logout: string = "Ops! Something wrong with logout! Try again";
  //Access
  public static message_error_user_has_no_access: string = "Ops! User has no access! Try again";

}