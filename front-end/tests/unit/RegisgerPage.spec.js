import { mount, createLocalVue } from "@vue/test-utils";
import "@testing-library/jest-dom";

import VueRouter from "vue-router";
import RegisterPage from "@/views/RegisterPage.vue";
import registrationService from "@/services/registration";

const localVue = createLocalVue();
localVue.use(VueRouter);
const router = new VueRouter();

jest.mock("@/services/registration");

describe("RegisterPage.vue", () => {
  let wrapper;
  let fieldUsername;
  let fieldEmailAddress;
  let fieldPassword;
  let buttonSubmit;
  let registerSpy;

  beforeEach(() => {
    wrapper = mount(RegisterPage, {
      localVue,
      router
    });
    fieldUsername = wrapper.find("#username");
    fieldEmailAddress = wrapper.find("#emailAddress");
    fieldPassword = wrapper.find("#password");
    buttonSubmit = wrapper.find('form button[type="submit"]');
    registerSpy = jest.spyOn(registrationService, "register");
  });

  afterEach(() => {
    registerSpy.mockReset();
    registerSpy.mockRestore();
  });

  afterAll(() => {
    jest.restoreAllMocks();
  });

  it("should render registration form", () => {
    expect(wrapper.find(".logo").attributes().src).toEqual(
      "/static/images/logo.png"
    );
    expect(wrapper.find(".tagline").text()).toEqual(
      "Open Source task management tool"
    );
    expect(fieldUsername.element.value).toEqual("");
    expect(fieldEmailAddress.element.value).toEqual("");
    expect(fieldPassword.element.value).toEqual("");
    expect(buttonSubmit.text()).toEqual("Create Account");
  });

  it("should contain data model with initial values", () => {
    expect(wrapper.vm.form.username).toEqual("");
    expect(wrapper.vm.form.emailAddress).toEqual("");
    expect(wrapper.vm.form.password).toEqual("");
  });

  it("should have form inputs bound with data model", async () => {
    let data = {
      form: {
        username: "sunny",
        emailAddress: "sunny@local",
        password: "VueJsRocks!"
      }
    };

    await wrapper.setData(data);

    expect(fieldUsername.element.value).toEqual(data.form.username);
    expect(fieldEmailAddress.element.value).toEqual(data.form.emailAddress);
    expect(fieldPassword.element.value).toEqual(data.form.password);
  });

  it("should have form submit event handler `submitForm`", () => {
    const spySubmit = jest.spyOn(wrapper.vm, "submitForm");

    buttonSubmit.trigger("submit");
    expect(spySubmit).toBeCalled();
  });

  it("should register when it is a new user", async () => {
    let data = {
      form: {
        username: "sunny",
        emailAddress: "sunny@local",
        password: "Jest!"
      },
      errorMessage: ""
    };

    await wrapper.setData(data);

    const stub = jest.fn();
    wrapper.vm.$router.push = stub;
    wrapper.vm.submitForm();

    expect(registerSpy).toBeCalled();

    await wrapper.vm.$nextTick();
    expect(stub).toHaveBeenCalledWith({ name: "LoginPage" });
  });

  it("should fail it is not a new user", async () => {
    let data = {
      form: {
        username: "sunny",
        emailAddress: "ted@local",
        password: "Jest!"
      },
      errorMessage: ""
    };

    await wrapper.setData(data);

    //expect(wrapper.find(".failed").isVisible()).toBe(false);
    expect(wrapper.find(".failed").element).not.toBeVisible();
    await wrapper.vm.submitForm(); //여기도 AWAIT 걸어주니까 최종적으로 해결되었다

    expect(registerSpy).toBeCalled();

    await wrapper.vm.$nextTick();

    //expect(wrapper.find(".failed").isVisible()).toBe(true);
    expect(wrapper.find(".failed").element).toBeVisible();
  });
});
