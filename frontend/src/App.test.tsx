import { render, screen } from "@testing-library/react";
import App from "./App";

describe("App component", () => {
    it("renders the heading", () => {
        render(<App />);

        expect(screen.getByRole("heading", { name: "Hello World!" })).toBeInTheDocument();
    });
});